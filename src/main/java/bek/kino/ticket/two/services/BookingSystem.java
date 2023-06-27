package bek.kino.ticket.two.services;


import bek.kino.ticket.two.model.User;
import bek.kino.ticket.two.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingSystem {


    private final UserRepository userRepository;

    public boolean minusBalance(User user,int price){
        int currentBalance = user.getBalance() - price;
        if(user.getBalance() >= price){
            user.setBalance(currentBalance);
            userRepository.save(user);
            return true;
        }
        return false;
    }

}
