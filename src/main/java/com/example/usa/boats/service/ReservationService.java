package com.example.usa.boats.service;

import com.example.usa.boats.model.ClientReport;
import com.example.usa.boats.model.ReservationModel;
import com.example.usa.boats.model.ReservationReport;
import com.example.usa.boats.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservation(){
        return reservationRepository.getAllReservation();
    }
    public Optional<ReservationModel> getReservation(Integer id){
        return reservationRepository.getReservation(id);
    }
    public ReservationModel saveReservation(ReservationModel reservationModel){
        if(reservationModel.getIdReservation()==null){
            return reservationRepository.saveReservation(reservationModel);
        }else {
            Optional<ReservationModel> reservationEncontrada = getReservation(reservationModel.getIdReservation());
            if (reservationEncontrada.isEmpty()){
                return reservationRepository.saveReservation(reservationModel);
            }else {
                return reservationModel;
            }
        }
    }
    public boolean deleteReservation(Integer id){
        Boolean respuesta = getReservation(id).map(elemento -> {
            reservationRepository.deleteReservation(elemento.getIdReservation()); //
            return true;
        }).orElse(false);
        return respuesta;
    }
    public ReservationModel updateReservation(ReservationModel reservationModel){
        if (reservationModel.getIdReservation()!=null){
            Optional<ReservationModel> reservationEncontrado = getReservation(reservationModel.getIdReservation());
            if (!reservationEncontrado.isEmpty()){
                if (reservationModel.getStartDate()!=null){
                    reservationEncontrado.get().setStartDate(reservationModel.getStartDate());
                }
                if (reservationModel.getDevolutionDate()!=null){
                    reservationEncontrado.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if (reservationModel.getStatus()!=null){
                    reservationEncontrado.get().setStatus(reservationModel.getStatus());
                }
                return reservationRepository.saveReservation(reservationEncontrado.get());
            }
        }
        return reservationModel;
    }
    public ReservationReport getReservationStatusReport(){
        List<ReservationModel> completed = reservationRepository.getReservationByStatus("completed");
        List<ReservationModel> canceled = reservationRepository.getReservationByStatus("cancelled");
        return new ReservationReport(completed.size(), canceled.size());
    }
    public List<ReservationModel> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate= new Date();
        Date bDate= new Date();

        try {
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }
        if(aDate.before(bDate)){
            return reservationRepository.getReservationPeriod(aDate, bDate);
        }else{
            return new ArrayList<>();
        }
    }
    public List<ClientReport> getTopClients(){
        return reservationRepository.getTopClients();
    }
}
