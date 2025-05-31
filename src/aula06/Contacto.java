package aula06;

public class Contacto {
    private static int lastID = 1;
    private int id;
    private Pessoa pessoa;
    private String numero;
    private String email;

    public Contacto(Pessoa pessoa, String numero, String email) {
        this.id = lastID++;
        this.pessoa = pessoa;
        setNumero(numero);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero.length() == 9 && numero.charAt(0) == '9') {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("Numero de inválido, deve ter 9 digitos e começar com 9");
        }
    
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@") && (email.endsWith(".pt") || email.endsWith(".com"))) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("mail invalido, deve conter @ e terminar com .pt ou .com");
        }
        
    }

    @Override
    public String toString() {
        return "Contacto: ID: " + id + ", Pessoa: " + pessoa.getName() + ", Telefone: " + numero + ", Email: " + email ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contacto other = (Contacto) obj;
        if (id != other.id)
            return false;
        if (pessoa == null) {
            if (other.pessoa != null)
                return false;
        } else if (!pessoa.equals(other.pessoa))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }
}

