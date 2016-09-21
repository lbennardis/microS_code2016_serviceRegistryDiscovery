package it.luigibennardis.microservice.repositories;

import it.luigibennardis.microservice.domain.BatteryInventory;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "batteryinventory", path = "batteryinventory")
public interface IBatteryInventoryRepository extends PagingAndSortingRepository<BatteryInventory, String> {
	List<BatteryInventory> findBystationid(@Param("stationid") String stationid);
}

