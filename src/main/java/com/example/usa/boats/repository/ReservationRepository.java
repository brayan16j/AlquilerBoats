package com.example.usa.boats.repository;

import com.example.usa.boats.model.ClientModel;
import com.example.usa.boats.model.ClientReport;
import com.example.usa.boats.model.ReservationModel;
import com.example.usa.boats.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAllReservation(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }
    public Optional<ReservationModel> getReservation(Integer id){
        return reservationCrudRepository.findById(id);
    }
    public ReservationModel saveReservation(ReservationModel reservationModel){
        return reservationCrudRepository.save(reservationModel);
    }
    public boolean deleteReservation(Integer id){
        reservationCrudRepository.deleteById(id);
        return true;
    }
    public ReservationModel updateReservation(ReservationModel reservationModel){
        return reservationCrudRepository.save(reservationModel);
    }

    public List<ReservationModel> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<ReservationModel> getReservationPeriod(Date dateOne, Date dateTwo ){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<ClientReport> getTopClients(){
        List<ClientReport> response = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for (int i =0; i< report.size(); i++){
            response.add(new ClientReport((Long) report.get(i)[1], (ClientModel) report.get(i)[0]));
        }
        return response;
    }
}
