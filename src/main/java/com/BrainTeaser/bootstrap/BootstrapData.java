package com.BrainTeaser.bootstrap;

import com.BrainTeaser.model.*;
import com.BrainTeaser.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner
{
    private final AnswerKeyRepository answerKeyRepository;
    private final ApplicationUserRepository applicationUserRepository;
    private final CategoryRepository categoryRepository;
    private final DifficultyRepository difficultyRepository;
    private final QuestionPaperRepository questionPaperRepository;
    private final QuizRepository quizRepository;
    private final TagsRepository tagsRepository;
    private final TopicRepository topicRepository;
    private final UserProfileRepository userProfileRepository;

    @Override
    public void run(String... args) throws Exception {

        // 1. Create Categories
        Category cat1 = new Category();
        cat1.setCategoryName("General Knowledge");
        Category cat2 = new Category();
        cat2.setCategoryName("Science");

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        // 2. Create Difficulties
        Difficulty diff1 = new Difficulty();
        diff1.setDifficultyName("Easy");
        Difficulty diff2 = new Difficulty();
        diff2.setDifficultyName("Medium");

        difficultyRepository.save(diff1);
        difficultyRepository.save(diff2);

        // 3. Create Topics
        Topic topic1 = new Topic();
        topic1.setTopicName("Physics");
        Topic topic2 = new Topic();
        topic2.setTopicName("History");

        topicRepository.save(topic1);
        topicRepository.save(topic2);

        // 4. Create Tags
        Tags tag1 = new Tags();
        tag1.setTagName("Important");
        Tags tag2 = new Tags();
        tag2.setTagName("Revision");

        tagsRepository.save(tag1);
        tagsRepository.save(tag2);

        // 5. Create QuestionPaper
        QuestionPaper qp1 = new QuestionPaper();
        qp1.setTitle("Physics Paper 1");
        qp1.setTopic(topic1);

        QuestionPaper qp2 = new QuestionPaper();
        qp2.setTitle("History Paper 1");
        qp2.setTopic(topic2);

        questionPaperRepository.save(qp1);
        questionPaperRepository.save(qp2);

        // 6. Create Quiz Questions
        Quiz q1 = new Quiz();
        q1.setQuestionText("What is the speed of light?");
        q1.setOptionA("3x10^8 m/s");
        q1.setOptionB("5x10^6 m/s");
        q1.setOptionC("1x10^4 m/s");
        q1.setOptionD("7x10^3 m/s");
        q1.setQuestionPaper(qp1);

        Quiz q2 = new Quiz();
        q2.setQuestionText("Who discovered gravity?");
        q2.setOptionA("Newton");
        q2.setOptionB("Einstein");
        q2.setOptionC("Galileo");
        q2.setOptionD("Tesla");
        q2.setQuestionPaper(qp2);

        quizRepository.save(q1);
        quizRepository.save(q2);

        // 7. Create AnswerKey
        AnswerKey ak1 = new AnswerKey();
        ak1.setQuestionPaper(qp1);
        ak1.getAnswers().put(1, "A");

        AnswerKey ak2 = new AnswerKey();
        ak2.setQuestionPaper(qp2);
        ak2.getAnswers().put(1, "A");

        answerKeyRepository.save(ak1);
        answerKeyRepository.save(ak2);

        // Save Roles
        // Make sure you have a RolesRepository if needed
        // rolesRepository.save(adminRole);
        // rolesRepository.save(userRole);

        // 9. Create Users
        ApplicationUser user1 = new ApplicationUser();
        user1.setUsername("admin");
        user1.setEmail("admin@example.com");
        user1.setPassword("password"); // encrypt in real apps
        user1.setStatus("ACTIVE");

        ApplicationUser user2 = new ApplicationUser();
        user2.setUsername("user");
        user2.setEmail("user@example.com");
        user2.setPassword("password");
        user2.setStatus("ACTIVE");

        applicationUserRepository.save(user1);
        applicationUserRepository.save(user2);

        // 10. Create UserProfile
        UserProfile profile1 = new UserProfile();
        profile1.setEmail("user1@example.com");
        profile1.setFirstName("John");
        profile1.setLastName("Doe");
        profile1.setPhoneNumber("1234567890");

        userProfileRepository.save(profile1);

        System.out.println("Bootstrap data loaded successfully!");
    }

}
