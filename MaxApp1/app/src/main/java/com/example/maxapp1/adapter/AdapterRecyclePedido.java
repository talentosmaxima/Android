package com.example.maxapp1.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maxapp1.R;
import com.example.maxapp1.interfaces.RecycleViewOnclickListenerHack;
import com.example.maxapp1.modelo.Pedido;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * Created by wanderson on 15/09/19.
 */

public class AdapterRecyclePedido extends RecyclerView.Adapter<AdapterRecyclePedido.ViewHolder> {
    private List<Pedido> lista;
    private RecycleViewOnclickListenerHack recycleViewOnclickListenerHack;
    private LayoutInflater inflater;
    Context context;

    public AdapterRecyclePedido(Context context, List<Pedido> l ){
        this.context=context;
        this.lista=l;
        this.inflater=(LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }

    public void setRecycleViewOnclickListenerHack(RecycleViewOnclickListenerHack r) {
        this.recycleViewOnclickListenerHack = r;
    }


    public void remove(int position){
        lista.remove( position );
        notifyItemRemoved( position );
    }


    public void addLista(Pedido p , int position){
        lista.add( p );
        notifyItemInserted( position );

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate( R.layout.item_lista_pedidos,parent,false );
        ViewHolder vh = new ViewHolder(v );

        return vh;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        int pos=position;
        holder.clienteNumNome.setText(lista.get( pos ).getNOMECLIENTE());
        holder.RCA_ERP.setText(lista.get( pos ).getNumero_ped_Rca()+"/"+lista.get( pos ).getNumero_ped_erp());
        Calendar calendar = Calendar.getInstance();
        Calendar calendarHoje = Calendar.getInstance();
        final Date dataM = lista.get( pos ).getData();
        calendar.setTimeInMillis(dataM.getTime());
        calendarHoje.setTimeInMillis(new Date().getTime());
        String hoje =calendarHoje.get(Calendar.DAY_OF_MONTH)+"-"+calendarHoje.get(Calendar.MONTH)+"-"+calendarHoje.get(Calendar.YEAR);
        String dataMarcada =calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.YEAR);
        String nomeMes="";
        switch (calendar.get(Calendar.MONTH)){
            case 0:
                nomeMes="JAN";
                break;
            case 1:
                nomeMes="FEV";
                break;
            case 2:
                nomeMes="MAR";
                break;
            case 3:
                nomeMes="ABR";
                break;
            case 4:
                nomeMes="MAI";
                break;
            case 5:
                nomeMes="JUN";
                break;
            case 6:
                nomeMes="JUL";
                break;
            case 7:
                nomeMes="AGO";
                break;
            case 8:
                nomeMes="SET";
                break;
            case 9:
                nomeMes="OUT";
                break;
            case 10:
                nomeMes="NOV";
                break;
            case 11:
                nomeMes="DEZ";
                break;

        }

        if(!hoje.equals(dataMarcada)) {
            holder.dataPedido.setText(calendar.get(Calendar.DAY_OF_MONTH) + " " + nomeMes);

        }else {
            int hora = calendar.get(Calendar.HOUR_OF_DAY);
            int minuto = calendar.get(Calendar.MINUTE);
            if(minuto<10){
                holder.dataPedido.setText(hora+" : 0"+minuto);

            }else {
                holder.dataPedido.setText(hora + " : " + minuto);
            }
        }

        holder.processo.setText(lista.get( pos ).getStatus());
        holder.preco.setText("R$628,00");
        String status=  lista.get( pos ).getStatus().toUpperCase(Locale.ROOT);
        String texto=  "";
        String critica=  "";
        if(lista.get( pos ).getCritica()!=null){
            critica=lista.get( pos ).getCritica();
        }
        Resources res=  context.getResources();
        Drawable drawableCriticaimg;
        switch (critica.toUpperCase(Locale.ROOT)){
            case  "SUCESSO"  :
                drawableCriticaimg = ResourcesCompat.getDrawable(res, R.drawable.ic_maxima_critica_sucesso, null);
                break;

            case  "FALHA_PARCIAL"  :
                drawableCriticaimg = ResourcesCompat.getDrawable(res, R.drawable.ic_maxima_critica_alerta, null);
                break;
            case  "FALHA_TOTAL"  :
                drawableCriticaimg = ResourcesCompat.getDrawable(res, R.drawable.ic_maxima_critica_falha_total, null);
                break;
            default:
                drawableCriticaimg = ResourcesCompat.getDrawable(res, R.drawable.ic_maxima_aguardando_critica, null);
                break;

        }

        Drawable drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_bt_pendente, null);

        switch (status.toUpperCase(Locale.ROOT)){
            case  "EM PROCESSAMENTO"  :
                drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_em_process, null);

                texto="";
                break;

            case  "PENDENTE"  :
                drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_bt_pendente, null);

                texto="P";
                break;
            case  "PROCESSADO"  :
                drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_bt_liber, null);
                texto="L";
                break;
            case  "ORCAMENTO"  :
                drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_bt_orc, null);
                texto="O";
                break;
            case  "CANCELADO"  :
                drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_bt_canc, null);
                texto="C";
                break;
            case  "BLOQUEADO"  :
                drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_bt_bloq, null);
                texto="B";
                break;
            case  "FATURADO"  :
                drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_bt_fatur, null);
                texto="F";
                break;
            case  "MONTADO"  :
                drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_bt_mont, null);
                texto="M";
                break;
            case  "RECUSADO"  :
                drawableStatus = ResourcesCompat.getDrawable(res, R.drawable.ic_bt_recus, null);
                texto="!";
                break;


        }

        LinearLayout grupoView = new LinearLayout(context);
        grupoView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));


String[] legendas = lista.get( pos ).getLegendas();



        for (String l:legendas) {

            if (l.equals("PEDIDO_SOFREU_CORTE")) {
                holder.PEDIDO_SOFREU_CORTE.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) holder.PEDIDO_SOFREU_CORTE.getLayoutParams();
                params.width = 15;
                holder.PEDIDO_SOFREU_CORTE.setLayoutParams(params);
            }
            if (l.equals("PEDIDO_FEITO_TELEMARKETING")) {
                holder.PEDIDO_FEITO_TELEMARKETING.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) holder.PEDIDO_FEITO_TELEMARKETING.getLayoutParams();
                params.width = 15;
                holder.PEDIDO_FEITO_TELEMARKETING.setLayoutParams(params);
            }
            if (l.equals("PEDIDO_CANCELADO_ERP")) {
                holder.PEDIDO_CANCELADO_ERP.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) holder.PEDIDO_CANCELADO_ERP.getLayoutParams();
                params.width = 15;
                holder.PEDIDO_CANCELADO_ERP.setLayoutParams(params);
            }
            if (l.equals("PEDIDO_COM_FALTA")) {
                holder.PEDIDO_COM_FALTA.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) holder.PEDIDO_COM_FALTA.getLayoutParams();
                params.width = 15;
                holder.PEDIDO_COM_FALTA.setLayoutParams(params);
            }
            if (l.equals("PEDIDO_COM_DEVOLUÇÃO")) {
                holder.PEDIDO_COM_DEVOLUÇÃO.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) holder.PEDIDO_COM_DEVOLUÇÃO.getLayoutParams();
                params.width = 15;
                holder.PEDIDO_COM_DEVOLUÇÃO.setLayoutParams(params);
            }

        }


        holder.bt_status.setBackground(drawableStatus);
        holder.bt_status.setText(texto);


        holder.criticaimg.setImageDrawable(drawableCriticaimg);
         Typeface face = Typeface.createFromAsset(context.getAssets(),
                "Fonts/Santral-Bold.ttf");
        holder.RCA_ERP.setTypeface(face);
        holder.processo.setTypeface(face);
        holder.clienteNumNome.setTypeface(face);
        holder.preco.setTypeface(face);


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView clienteNumNome ;
        public TextView RCA_ERP ;
        public TextView dataPedido ;
        public TextView processo ;
        public TextView preco ;
        public ImageView criticaimg ;
        public ImageView PEDIDO_COM_DEVOLUÇÃO ;
        public ImageView PEDIDO_COM_FALTA ;
        public ImageView PEDIDO_FEITO_TELEMARKETING ;
        public ImageView PEDIDO_CANCELADO_ERP ;
        public ImageView PEDIDO_SOFREU_CORTE ;

        public Button bt_status ;

        public LinearLayout legendasLayout ;


        public ViewHolder(View itemView) {
            super( itemView );
            clienteNumNome = itemView.findViewById( R.id.clienteNumNome );
            RCA_ERP = itemView.findViewById( R.id.RCA_ERP );
            dataPedido = itemView.findViewById( R.id.dataPedido );
            processo = itemView.findViewById( R.id.processo );
            preco = itemView.findViewById( R.id.preco );
            criticaimg = itemView.findViewById( R.id.criticaimg );
            bt_status = itemView.findViewById( R.id.bt_status );
             PEDIDO_COM_DEVOLUÇÃO  = itemView.findViewById( R.id.PEDIDO_COM_DEVOLUÇÃO );
             PEDIDO_COM_FALTA  = itemView.findViewById( R.id.PEDIDO_COM_FALTA );
             PEDIDO_FEITO_TELEMARKETING  = itemView.findViewById( R.id.PEDIDO_FEITO_TELEMARKETING );
             PEDIDO_CANCELADO_ERP  = itemView.findViewById( R.id.PEDIDO_CANCELADO_ERP );
             PEDIDO_SOFREU_CORTE  = itemView.findViewById( R.id.PEDIDO_SOFREU_CORTE );

            legendasLayout = itemView.findViewById( R.id.legendasLayout );


        }

        @Override
        public void onClick(View v) {

            if(recycleViewOnclickListenerHack!=null){
                recycleViewOnclickListenerHack.onClickListener(v,getPosition());
            }

        }
    }

}
