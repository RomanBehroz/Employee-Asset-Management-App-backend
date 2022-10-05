package com.romanyou.Employee.Asset.Management.repository;

import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.entity.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for return Table
 */
@Repository
public interface ReturnRepository extends JpaRepository<Return, Long> {

    /**
     * finds all the Returns by Employee
     * @param employee
     * @return
     */
    List<Return> findAllByEmployee (Employee employee);

    /**
     * finds 3 latest returns
     * @return list of returns
     */
    @Query(nativeQuery = true, value = "SELECT * FROM return ORDER BY return_id DESC LIMIT 3")
    List<Return> findLast5Returns();
}
