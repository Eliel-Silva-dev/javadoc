package br.com.enumerated.aula01;

public enum TipoDocumento {

    CPF {
        @Override
        public String geraNumeroTeste() {
            return GeraCpfCnpj.cpf();
        }

        @Override
        public boolean verificaNumero(String numero) {
            return GeraCpfCnpj.isCPF(numero);
        }

    }, CNPJ {
        @Override
        public String geraNumeroTeste() {
            return GeraCpfCnpj.cnpj();
        }

        @Override
        public boolean verificaNumero(String numero) {
            return GeradorCpfCnpj.validarCNPJ(numero);
        }

    };

    public abstract String geraNumeroTeste();

    public abstract boolean verificaNumero(String numero);
}
