package br.com.mobintech.barbearia.security;

import br.com.mobintech.barbearia.models.enums.PerfilUsuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserSpringSecurity implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSpringSecurity() {
    }

    public UserSpringSecurity(Long id, String email, String senha, PerfilUsuario perfilUsuario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(perfilUsuario.getDescricao()));
        this.authorities = authorities;
    }

    public Long getId(){
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(PerfilUsuario perfilUsuario) {
        return getAuthorities().contains(new SimpleGrantedAuthority(perfilUsuario.getDescricao()));
    }
}