package com.ll.exam;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.ll.exam.article.controller.ArticleController;

import java.util.List;

public class AppTest {
    @Test
    public void junit_assertThat() {
        int rs = 10 + 20;

        assertThat(rs).isEqualTo(30);
    }
    @Test
    public void ioc__articleController() {
        ArticleController articleController = Container.getArticleController();

        assertThat(articleController).isNotNull();
    }
    @Test
    public void ioc__articleController__싱글톤() {
        ArticleController articleController1 = Container.getArticleController();
        ArticleController articleController2 = Container.getArticleController();

        assertThat(articleController2).isEqualTo(articleController1);
    }
    @Test
    public void ioc__Controller들을_스캔하여_수집() {
        List<String> names = Container.getControllerNames();

        assertThat(names).contains("home");
        assertThat(names).contains("article");
    }
}

