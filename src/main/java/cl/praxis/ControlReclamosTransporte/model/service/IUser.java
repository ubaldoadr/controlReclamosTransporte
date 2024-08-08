package cl.praxis.ControlReclamosTransporte.model.service;

import cl.praxis.ControlReclamosTransporte.model.entity.User;

import java.util.List;

public interface IUser {
    List<User> findAll();
    User findOne(int id);
    boolean create(User u);
    boolean update(User u);
    boolean delete(int id);

}
