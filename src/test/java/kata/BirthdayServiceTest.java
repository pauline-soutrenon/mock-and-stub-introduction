package kata;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import notification.Mailer;

import org.junit.Test;
import org.mockito.Mockito;

import clients.ClientRepository;

public class BirthdayServiceTest {

  private ClientRepository repository = Mockito.mock(ClientRepository.class);
  private Mailer mailer = mock(Mailer.class);  
  private BirthdayService birthdayService = new BirthdayService(repository, mailer);
  
  @Test public void 
  on_Ordinary_Days_Greetins_Is_Hello() throws Exception {
    
    when(repository.birthdayIsTodayFor("John")).thenReturn(true);

    birthdayService.greeting("Claire");
    
    verify(mailer).send("Good morning Claire.");
  }
  
  @Test public void 
  on_Birthdays_It_Wishes_Happy_Birthday() throws Exception {
   
    when(repository.birthdayIsTodayFor("John")).thenReturn(true);
    
    birthdayService.greeting("John");
    
    verify(mailer).send("Happy birthday John!");
  }
  
  
  

}
