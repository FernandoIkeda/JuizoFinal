package utfpr.ct.dainf.if62c.avaliacao;

import java.util.TimerTask;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial 4.
 * @author Fernando
 */
public class Aviso extends TimerTask {
    
    protected final Compromisso compromisso;

    public Aviso(Compromisso compromisso) {
       this.compromisso = compromisso;
       
        @Override
            public void run() {
                int tempo = (int)(compromisso.getData().getTime() - System.currentTimeMillis())/1000;
                System.out.println(compromisso.getDescricao() + " começa em " + tempo + "s");
            }
    
    }
        
}
