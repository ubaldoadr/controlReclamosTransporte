package cl.praxis.ControlReclamosTransporte.model.service;





import cl.praxis.ControlReclamosTransporte.model.entity.User;
import cl.praxis.ControlReclamosTransporte.model.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class UserServiceImpl implements IUser{

        private final PasswordEncoder passwordEncoder;
        private final UserRepository repository;

        public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
            this.repository = repository;
            this.passwordEncoder=passwordEncoder;
        }

        @Override
        public List<User> findAll() {
            return repository.findAll();
        }

        @Override
        public User findOne(int id) {
            return repository.findById(id).orElse(null);
        }


        @Override
        public boolean create(User u) {

            u.setPassword(passwordEncoder.encode(u.getPassword()));
            return repository.save(u) != null;
        }

        @Override
        public boolean update(User u) {
            return repository.save(u) != null;
        }

        @Override
        public boolean delete(int id) {
            boolean exist = repository.existsById(id);
            if (exist){
                repository.deleteById(id);
            }
            return exist;
        }
    }
