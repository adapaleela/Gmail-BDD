package tests;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"E:\\leelajava\\gmailtest\\src\\test\\resources\\repository\\gmailfeature.feature"},
							monochrome=true,
							plugin={"pretty","html:target\\result"}
				)
public class Gmailrunner 
{

}
