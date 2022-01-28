package com.example.maxapp1.ui.dashboard;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maxapp1.R;
import com.example.maxapp1.adapter.AdapterRecyclePedido;
import com.example.maxapp1.controller.PedidoRest;
import com.example.maxapp1.dao.Conectado;
import com.example.maxapp1.modelo.Pedido;
import com.example.maxapp1.modelo.Pedidos;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    private RecyclerView mRecyclerView;

    private List<Pedido> listaR;
    private int position = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        try {
            PedidoRest pedidoRest = new PedidoRest(view.getContext());

            final Pedidos pedidos  = pedidoRest.getBuscarPedido();

            if(pedidos==null && Conectado.conectado()){
                AlertDialog.Builder alerta = new AlertDialog.Builder(view.getContext());
                alerta.setTitle("Via REST");
                alerta.setIcon(R.mipmap.ic_maxima_pessoa).setMessage("Dados carregados com sucesso!!").setCancelable(false).
                        setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Fragment newFragment = new DashboardFragment();
                                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.nav_host_fragment, newFragment);
                                transaction.addToBackStack(null);

                                transaction.commit();

                            }
                        });
                AlertDialog alertDialog = alerta.create();
                alertDialog.show();
            }





            mRecyclerView = view.findViewById(R.id.recicleview);
            mRecyclerView.setHasFixedSize(true);
            listaR = new ArrayList<>();

            for (Pedido p :pedidos.getPedidos()) {
                listaR.add(p);

            }


            mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                }
            });
            LinearLayoutManager lm = new LinearLayoutManager(view.getContext());
            lm.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(lm);
            AdapterRecyclePedido adapterRecycle = new AdapterRecyclePedido(view.getContext(), listaR);
            mRecyclerView.setAdapter(adapterRecycle);


        }catch (Exception e) {


        }

        return view;
    }

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }
}
