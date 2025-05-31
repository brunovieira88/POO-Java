package aula07;

public class Quadro extends Obra{
        private String tipoTinta, tamanhoTela;
        private boolean emoldurada;

        public Quadro(String nome, String autor, double preco, String tipoTinta, boolean emoldurada, String tamanhoTela) {
            super(nome, autor, preco);
            this.tipoTinta = tipoTinta;
            this.emoldurada = emoldurada;
            this.tamanhoTela = tamanhoTela;
        }

        public String getTipoTinta() {
            return tipoTinta;
        }

        public void setTipoTinta(String tipoTinta) {
            this.tipoTinta = tipoTinta;
        }
        public String getTamanhoTela() {
            return tamanhoTela;
        }

        public void setTamanhoTela(String tamanhoTela) {
            this.tamanhoTela = tamanhoTela;
        }

        public boolean isEmoldurada() {
            return emoldurada;
        }

        public void setEmoldurada(boolean emoldurada) {
            this.emoldurada = emoldurada;
        }

        @Override 
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" Tipo de Tinta: ").append(tipoTinta );
            sb.append(" Emoldurada: ").append(emoldurada ? "Sim" : "Nao");
            sb.append(" Tamanho Tela: ").append(tamanhoTela);
            return sb.toString();
        }
}
