package project1_T4.timkiem.repository;

import java.util.List;

import project1_T4.timkiem.repository.entity.UserEntity;



public interface UserRepository {
 List<UserEntity> findUserIdByFullName (Integer id);
}
