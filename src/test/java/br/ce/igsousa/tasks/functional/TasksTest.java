package br.ce.igsousa.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		//estrategia de espera
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			
			//escrever a desc da task
			driver.findElement(By.id("task")).sendKeys("Teste automatico via selenium");
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
			//escrever a data
			
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);
		} finally {
			//fechar browser
			driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			
			//escrever a desc da task
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
			//escrever a data
			
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
		} finally {
			//fechar browser
			driver.quit();
		}
	}
	
}
