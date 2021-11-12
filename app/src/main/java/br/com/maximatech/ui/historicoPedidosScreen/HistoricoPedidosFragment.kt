package br.com.maximatech.ui.historicoPedidosScreen

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.maximatech.R
import br.com.maximatech.core.extensions.showSnackbarWithAnchorView
import br.com.maximatech.data.model.Pedido
import br.com.maximatech.databinding.FragmentHistoricoPedidosBinding
import br.com.maximatech.databinding.LegendasCustomDialogBinding
import br.com.maximatech.ui.State
import br.com.maximatech.ui.ViewManagerState

class HistoricoPedidosFragment : Fragment() {

    private lateinit var binding: FragmentHistoricoPedidosBinding
    private lateinit var viewModel: HistoricoPedidosViewModel
    private lateinit var adapter: HistoricoPedidosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoricoPedidosBinding.inflate(inflater, container, false)
        adapter = HistoricoPedidosAdapter()
        setHasOptionsMenu(true)
        val root = binding.root
        viewModel = ViewModelProvider(this).get(HistoricoPedidosViewModel::class.java)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.label_hist_de_pedidos)
        val viewManager = ViewManagerState(
            binding.rvPedidos, binding.btnTentarNovamente, binding.loading
        )

        viewModel.fetchData()

        binding.rvPedidos.layoutManager = LinearLayoutManager(context)
        binding.rvPedidos.adapter = adapter

        binding.btnTentarNovamente.setOnClickListener {
            viewManager.loading()
            viewModel.fetchData()
        }

        viewModel.pedidosList.observe(viewLifecycleOwner) {
            adapter.updateList(it as MutableList<Pedido>?)
        }

        viewModel.apiRequestState.observe(viewLifecycleOwner)
        { state ->
            when (state) {
                State.SUCCESS -> {
                    viewManager.success()
                }
                State.LOADING -> {
                    viewManager.loading()
                }
                State.ERROR -> {
                    viewManager.error()
                    view.showSnackbarWithAnchorView(
                        message = getString(R.string.hist_pedidos_error_loading),
                    )
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.hist_pedidos_menu, menu)

        val search = menu.findItem(R.id.pesquisar_menu_action)
        val searchView = search?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.legenda_menu_action) {
            showLegendasDialog(requireContext())
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showLegendasDialog(context: Context) {
        val binding = LegendasCustomDialogBinding.inflate(layoutInflater)
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)

        binding.btnFechar.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(binding.root)
        dialog.show()

    }
}