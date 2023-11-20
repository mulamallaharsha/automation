package com.amazon.testing.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.testing.v1.pojos.Product;

public class CapstoneDataStoreTest {

	static Connection con = null;

	private static Statement stmt;

	public static String DB_URL = "jdbc:mysql://127.0.0.1/app_db";

	public static String DB_USER = "db_user";

	public static String DB_PASSWORD = "db_user_pass";

	@BeforeTest
	public void setUp() throws Exception {
		try {

			String dbClass = "com.mysql.jdbc.Driver";
			Class.forName(dbClass);

			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("comeshere");
			e.printStackTrace();
		}
	}

	@Test
	public void test_duplicate_products() {
		try {
			String query = "SELECT count(id), product_name FROM app_db.product GROUP BY product_name;";

			ResultSet res = stmt.executeQuery(query);

			List<String> duplicateProductNames = new ArrayList<String>();
			while (res.next()) {
				res.getInt(1);

				if (res.getInt(1) > 1) {
					duplicateProductNames.add(res.getString(2));
				}
			}
			ArrayList<String> expected = new ArrayList<String>();
			expected.add("product 2");
			Assert.assertEquals(duplicateProductNames, expected);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_product_with_max_price() {
		final int MAX_PRICE = 65;
		try {
			String query = "SELECT * FROM product where price = (select max(price) from product);";

			ResultSet res = stmt.executeQuery(query);

			Product product = new Product();
			while (res.next()) {

				product.setId(res.getInt(1));
				product.setProduct_name(res.getString(2));
				product.setPrice(res.getInt(3));

			}

			Assert.assertEquals(product.getPrice(), MAX_PRICE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_most_sold_products() {
		try {
			String query = "SELECT count(id),product_id FROM app_db.order group by product_id;";

			ResultSet res = stmt.executeQuery(query);

			int mostSoldCount = 0;
			int mostSoldProductId = 0;
			while (res.next()) {
				if (res.getInt(1) > mostSoldCount) {
					mostSoldCount = res.getInt(1);
					mostSoldProductId = res.getInt(2);
				}

			}

			Assert.assertEquals(mostSoldProductId, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {

		if (con != null) {
			con.close();
		}
	}
}