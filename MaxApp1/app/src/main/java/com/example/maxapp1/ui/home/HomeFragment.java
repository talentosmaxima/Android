package com.example.maxapp1.ui.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.maxapp1.R;
import com.example.maxapp1.controller.ClienteRest;
import com.example.maxapp1.controller.DataHora;
import com.example.maxapp1.dao.Conectado;
import com.example.maxapp1.modelo.Cliente;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_home, container, false);


try {
    ClienteRest clienteRest = new ClienteRest(view.getContext());

    final Cliente cliente = clienteRest.getBuscarCliente();

    if(cliente==null && Conectado.conectado()){
        AlertDialog.Builder alerta = new AlertDialog.Builder(view.getContext());
        alerta.setTitle("Via REST");
        alerta.setIcon(R.mipmap.ic_maxima_pessoa).setMessage("Dados carregados com sucesso!!").setCancelable(false).
                setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Fragment newFragment = new HomeFragment();
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.nav_host_fragment, newFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();

                    }
                });
        AlertDialog alertDialog = alerta.create();
        alertDialog.show();
    }


    TextView txCodigoNomeRsocial = (TextView) view.findViewById(R.id.txCodigoNomeRsocial);
    txCodigoNomeRsocial.setText(cliente.getCodigo() + " - " + cliente.getRazao_social());

    TextView txCNPJ = (TextView) view.findViewById(R.id.txCNPJ);
    txCNPJ.setText(cliente.getCnpj());
    TextView txRamoAtividade = (TextView) view.findViewById(R.id.txRamoAtividade);
    txRamoAtividade.setText(cliente.getRamo_atividade());
    TextView txEndereco = (TextView) view.findViewById(R.id.txEndereco);
    txEndereco.setText(cliente.getEndereco());
    TextView txNomeFantasia = (TextView) view.findViewById(R.id.txNomeFantasia);
    txNomeFantasia.setText(cliente.getNomeFantasia());




    TextView txNomeContato = (TextView) view.findViewById(R.id.txNomeContato);
    txNomeContato.setText(cliente.getContatos()[0].getNome());
    TextView txTelefone = (TextView) view.findViewById(R.id.txTelefone);
    txTelefone.setText(cliente.getContatos()[0].getTelefone());
    TextView txCelular = (TextView) view.findViewById(R.id.txCelular);
    txCelular.setText(cliente.getContatos()[0].getCelular());
    TextView txConjuge = (TextView) view.findViewById(R.id.txConjuge);
    txConjuge.setText(cliente.getContatos()[0].getConjuge());
    TextView txTipo = (TextView) view.findViewById(R.id.txTipo);
    txTipo.setText(cliente.getContatos()[0].getTipo());
    TextView txTime = (TextView) view.findViewById(R.id.txTime);
    txTime.setText(cliente.getContatos()[0].getTime());
    TextView txEmail = (TextView) view.findViewById(R.id.txEmail);
    txEmail.setText(cliente.getContatos()[0].getE_mail());
    TextView txDataN = (TextView) view.findViewById(R.id.txDataN);

    txDataN.setText(cliente.getContatos()[0].getData_nascimento());
    TextView txDataNConjugue = (TextView) view.findViewById(R.id.txDataNConjugue);
    txDataNConjugue.setText(cliente.getContatos()[0].getDataNascimentoConjuge());

    final Button bt_status =  view.findViewById(R.id.bt_status);
    bt_status.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Snackbar.make(bt_status,new DataHora().getDataHora()+" - Status "+cliente.getStatus(),Snackbar.LENGTH_LONG).setAction("fechar",new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            }).show();
        }
    });

}catch (Exception e) {

}

        return view;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }




}