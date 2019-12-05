package ru.job4j.lsp.distribution;

import org.junit.Test;
import ru.job4j.lsp.interfaces.BaseProductInterface;
import ru.job4j.lsp.products.Food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * Class ControllQualityTest
 *
 * @author Petr B.
 * @since 02.12.2019, 15:43
 */
public class ControllQualityTest {
    @Test
    public void whenAddTrashProduct() {
        LocalDate create = LocalDate.of(2019, 11, 30);
        LocalDate expaire = LocalDate.of(2019, 12, 2);
        Food hotDog = new Food("Hot-Dog", create, expaire, 200);
        Food shaurma = new Food("Shaurma", create, expaire, 150);
        ArrayList<BaseProductInterface> list = new ArrayList<>(Arrays.asList(hotDog, shaurma));
        ControllQuality controll = new ControllQuality(list);
        controll.distributionProduct();
        assertThat(controll.getList().get("Trash"), is(2));
    }

    @Test
    public void whenAddWareHouseProduct() {
        LocalDate create = LocalDate.of(2019, 11, 30);
        LocalDate expaire = LocalDate.of(2020, 5, 10);
        Food packOfPepsi = new Food("Pepsi-Cola", create, expaire, 2000);
        ArrayList<BaseProductInterface> list = new ArrayList<>(Arrays.asList(packOfPepsi));
        ControllQuality controll = new ControllQuality(list);
        controll.distributionProduct();
        assertThat(controll.getList().get("WareHouse"), is(1));
    }

    @Test
    public void whenAddShopProductAndShopProductWithDisscount() {
        LocalDate create = LocalDate.of(2019, 12, 1);
        LocalDate expaire = LocalDate.of(2019, 12, 5);
        Food disscountItem = new Food("Shop", create, expaire, 200);
        ArrayList<BaseProductInterface> list = new ArrayList<>(Arrays.asList(disscountItem));
        ControllQuality controll = new ControllQuality(list);
        controll.distributionProduct();
        assertThat(controll.getList().get("Shop"), is(1));
    }
}