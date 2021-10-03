package model;

public class Contato {

    // Atributos
	private int id;
	private String nome;
	private String email;
	private String fone;

    // construtor
    public Contato(String _nome, String _email, String _fone) {
        this.nome = _nome;
        this.email = _email;
        this.fone = _fone;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setId(int id) {
        this.id = id;
    } 



}
