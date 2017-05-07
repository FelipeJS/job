package br.com.workme.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.workme.role.Role;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "email", unique = true)
	@Email(message = "*Utilize um email válido")
	@NotEmpty(message = "*Preencha o email")
	private String email;

	@Column(name = "password")
	@Length(min = 5, message = "*Senha precisa ter pelo menos 5 caracteres")
	@NotEmpty(message = "*Preencha a senha")
	@Transient
	private String password;

	@Column(name = "name")
	@NotEmpty(message = "*Preencha o nome")
	private String name;

	@Column(name = "last_name")
	@NotEmpty(message = "*Preencha o sobrenome")
	private String lastName;

	@Column(name = "active")
	private int active;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@NotEmpty(message = "*Preencha o CPF/CNPJ")
	@Column(name = "documento", unique = true)
	private String documento;

	@NotEmpty(message = "*Preencha o nome fantasia")
	@Column(name = "fantasia")
	private String fantasia;

	@NotEmpty(message = "*Preencha o telefone")
	@Column(name = "telefone")
	private String telefone;

	@NotEmpty(message = "*Preencha o endereço")
	@Column(name = "endereco")
	private String endereco;

	@NotEmpty(message = "*Preencha o bairro")
	@Column(name = "bairro")
	private String bairro;

	@NotEmpty(message = "*Preencha a cidade")
	@Column(name = "cidade")
	private String cidade;

	@NotEmpty(message = "*Preencha o estado")
	@Column(name = "estado")
	private String estado;

	@Column(name = "tipo")
	private int tipo;

	@NotEmpty(message = "*Preencha a categoria")
	@Column(name = "categoria")
	private String categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}