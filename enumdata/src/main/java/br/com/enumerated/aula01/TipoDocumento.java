package br.com.enumerated.aula01;

public enum TipoDocumento {

    CPF {
        @Override
        public String geraNumeroTeste() {
            return GeradorCpfCnpj.gerarCPF();
        }

        @Override
        public boolean verificaNumero(String numero) {
            return GeradorCpfCnpj.validarCpf(numero);
        }

    }, CNPJ {
        @Override
        public String geraNumeroTeste() {
            return GeradorCpfCnpj.geraCNPJ();
        }

        @Override
        public boolean verificaNumero(String numero) {
            return GeradorCpfCnpj.validarCNPJ(numero);
        }

    };

    public abstract String geraNumeroTeste();

    public abstract boolean verificaNumero(String numero);
}
