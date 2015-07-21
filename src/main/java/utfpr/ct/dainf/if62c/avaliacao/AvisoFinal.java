package utfpr.ct.dainf.if62c.avaliacao;

import java.util.TimerTask;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial 4.
 * @author Fernando
 */
public class AvisoFinal extends Aviso {

    public AvisoFinal(Compromisso compromisso) {
        super(compromisso);
        System.out.println(compromisso.descricao);
        System.out.println("começa agora");
    
        timer.cancel();
    }
    
}
