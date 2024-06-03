package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // Responsable for data access
public interface StudentRepository extends JpaRepository<Student, Long>{
    /*
     * For convention, every java class 
     * that we can use on db, will have
     * Repository on final class name
     * 
     */

     /* extends JpaRepository<Student, Long>
      * 
      * will extends from JpaRepository
      * throw two parameters:
      * Object type and ID type
      * <Student, Long> = Student Type
      * <Student, Long> = Long Type ID
      */

      // SELECT * FROM email WHERE = ?
      @Query("SELECT s FROM Student s WHERE s.email = ?1")
      Optional<Student> findStudentByEmail(String email);


}
