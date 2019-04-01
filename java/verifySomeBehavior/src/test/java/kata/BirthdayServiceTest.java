package kata;

import clients.ClientRepository;
import notification.Mailer;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BirthdayServiceTest {


    @Test
    public void name() {

        // Given
        ClientRepository repository = mock(ClientRepository.class);
        Mailer mailer = mock(Mailer.class);
        BirthdayService birthdayService = new BirthdayService(repository, mailer);
        Mockito.when(repository.birthdayIsTodayFor("bob")).thenReturn(true);
        ArgumentCaptor<String> greeting = ArgumentCaptor.forClass(String.class);

        // When
        birthdayService.greeting("bob");

        // Then
        Mockito.verify(mailer).send(greeting.capture());
        assertThat(greeting.getValue()).contains("Happy birthday");
    }

    @Test
    public void matchers() {

        // Given
        ClientRepository repository = mock(ClientRepository.class);
        Mailer mailer = mock(Mailer.class);
        BirthdayService birthdayService = new BirthdayService(repository, mailer);
        Mockito.when(repository.birthdayIsTodayFor("bob")).thenReturn(true);

        // When
        birthdayService.greeting("bob");

        // Then
        assertThat(Matchers.contains("Happy birthday")).isEqualTo("Happy birthday");

        Mockito.verify(mailer).send(Matchers.contains("Happy birthday"));
    }
}
