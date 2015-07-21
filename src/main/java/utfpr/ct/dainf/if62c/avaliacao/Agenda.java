package utfpr.ct.dainf.if62c.avaliacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.Date;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial 4.
 * @author Fernando
 */
public class Agenda {
    private final String descricao;
    private final List<Compromisso> compromissos = new ArrayList<>();
    private final Timer timer;
    private final Date atual = new Date();

    public Agenda(String descricao) {
        this.descricao = descricao;
        timer = new Timer(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }
    
    public void novoCompromisso(Compromisso compromisso) {
        compromissos.add(compromisso);
        Aviso aviso = new AvisoFinal(compromisso);
        compromisso.registraAviso(aviso);
        timer.schedule(aviso, compromisso.getData());
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia) {
        Aviso aviso = new Aviso(compromisso);
        compromisso.registraAviso(aviso);
        atual.setTime(System.currentTimeMillis());
        timer.schedule(aviso, compromisso.getData().getTime() - atual.getTime() - 1000*antecedencia);
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia, int intervalo) {
        Aviso aviso = new Aviso(compromisso);
        compromisso.registraAviso(aviso);
        atual.setTime(System.currentTimeMillis());
        timer.schedule(aviso, compromisso.getData().getTime() - atual.getTime() - 1000*ant, period*1000);
    }
    
    public void cancela(Compromisso compromisso) {
        for(Aviso avisoAtual: compromisso.getAvisos()){
            if(avisoAtual != null) 
                avisoAtual.cancel();
        }
        if(compromissos.contains(compromisso))
            compromissos.remove(compromisso);
    }
    
    public void cancela(Aviso aviso) {
        if(aviso != null) 
            aviso.cancel();
         aviso.compromisso.getAvisos().remove(aviso);
    }
    
    public void destroi() {
        for(Compromisso compromisso: compromissos){
                for(Aviso ultimo: compromisso.getAvisos()){
                    if(ultimo!=null)
                        ultimo.cancel();
                }
        }
        timer.cancel();
    }
}
