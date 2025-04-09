package harjoitustyo.levykokoelma.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import harjoitustyo.levykokoelma.domain.AppUser;
import harjoitustyo.levykokoelma.domain.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final AppUserRepository urepository;

    public UserDetailServiceImpl(AppUserRepository userRepository) {
        this.urepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        AppUser curruser = urepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username,
                ((AppUser) curruser).getPasswordHash(),
                AuthorityUtils.createAuthorityList(((AppUser) curruser).getRole()));

        return user;
    }
}
