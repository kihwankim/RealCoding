import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ChampionTest {

    private List<Champion> championList = new ArrayList<Champion>();

    @Before//test 하기 전에 시작되는 set up 작업을 해 주는 역할을 한다.
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    @Test//test를 해주는 annotation
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<String>();
        assertThat(emptyList, empty());//bean값 비교 해야한다. hrmcrest dependency 확인하기
    }

    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());
    }

    @Test
    public void 스트링문자열확인테스트() {
        String sampleString = "player Focus";
        String startString = "player";
        String endString = "Point";
        //assertThat(sampleString, anyOf(startsWith(startString)), contains());
        assertThat(sampleString, is(endsWith(endString)));
    }

    @Test
    public void 부동소수점체큰() {
        assertThat(3.14, closeTo(3, 0.2));
    }//오차 범위 지정

    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(2), anything());
    }//하나의 인자라도 가지고 올 수 있는지 판별 해줌

    @Test
    public void shouldChamionCountFive() {
        assertThat(championList.size(), is(5));
        assertThat(championList, hasSize(5));
    }

    @Test
    public void 서폿챔피언은타릭어어야한다() {
        Champion support = new Champion("타릭", "바텀");
        assertThat("타릭", is(support.getName()));
        assertThat("타릭", is(equalTo(support.getName())));
        assertThat("타릭", equalTo(support.getName()));
    }

    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("top", equalTo("탑")));
    }

    @Test
    public void shouldHaveSomeChampName() {
        List<String> championNames = Arrays.asList("루시안", "애쉬", "칼리오");
        assertThat(championNames.get(1), hasToString("애쉬"));
    }

    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filterdChampion = championList.stream().
                filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));
    }
}