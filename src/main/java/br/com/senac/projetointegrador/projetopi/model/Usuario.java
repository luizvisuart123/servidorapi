package br.com.senac.projetointegrador.projetopi.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.senac.projetointegrador.projetopi.enumerador.NivelAtividadeFisica;
import br.com.senac.projetointegrador.projetopi.util.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Where(clause = "active = true")
public class Usuario extends Pessoa implements UserDetails{
	private static final long serialVersionUID = -6555643810426575027L;
	
	@Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;
    private String username;
    private String password;
    private String roles;
    private boolean active;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    
    @Column(name = "peso", nullable = false)
    private Double peso;
    
    @Column(name = "altura", nullable = false)
    private Double altura;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_atividade_fisica", nullable = false)
    private NivelAtividadeFisica nivelAtividadeFisica;
    
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var roleList = this.roles.split(",");
        return Arrays.stream(roleList).map(r -> new SimpleGrantedAuthority("ROLE_" + r))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.accountExpired;
    }

    @Override	
    public boolean isAccountNonLocked() {
        return !this.accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
