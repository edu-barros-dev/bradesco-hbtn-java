import java.util.ArrayList;

public class ProcessadorVideo {

    ArrayList<CanalNotificacao> canais;

    public ProcessadorVideo() {
        this.canais = new ArrayList<>();
    }

    public void registrarCanal(CanalNotificacao canal) {
        this.canais.add(canal);
    }

    public void processar(Video video) {

        for (CanalNotificacao canal : canais) {
            Mensagem mensagem = new Mensagem(video.getArquivo() + " - " + video.getFormato(), TipoMensagem.LOG);
            canal.notificar(mensagem);
        }

    }

}