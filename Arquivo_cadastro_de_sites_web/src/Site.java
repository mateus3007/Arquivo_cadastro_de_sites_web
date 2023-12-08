import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descricao;
    private String url;
    private Date dataCadastro;

    public Site(String descricao, String url) {
        this.descricao = descricao;
        this.url = url;
        this.dataCadastro = new Date(); // data atual como data de cadastro
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + ", URL: " + url + ", Data de Cadastro: " + dataCadastro;
    }
}