package br.com.enumerated.aula01;

public enum TipoDocumento {

    CPF {
        @Override
        public String geraNumeroTeste() {
            return "Teste1";
        }
    }, CNPJ {
        @Override
        public String geraNumeroTeste() {
            return "Teste2";
        }
    };

    public abstract String geraNumeroTeste();
}
