package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.models.Usuario;
import br.com.mobintech.barbearia.repositories.UsuarioRepository;
import br.com.mobintech.barbearia.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null){
            throw new UsernameNotFoundException(email);
        }

        return new UserSpringSecurity(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfilDeUsuario());
    }
}