package project1_T4.timkiem.userrepository;

import java.util.List;

import project1_T4.timkiem.userrepository.entity.UserEntity;


public interface UserRepository {
 List<UserEntity> findUserIdByFullName (String fullname);
}
