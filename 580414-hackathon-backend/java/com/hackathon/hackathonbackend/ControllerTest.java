package com.hackathon.hackathonbackend;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.test.context.ContextConfiguration;
import com.hackathon.hackathonbackend.controller.ParticipationMetricsController;
import com.hackathon.hackathonbackend.genericmetric.GenericMetricOutputVo;
import com.hackathon.hackathonbackend.participationmetric.ParticipationMetricsCustomRepository;
import com.hackathon.hackathonbackend.participationmetric.ParticipationMetricsRepository;
import com.hackathon.hackathonbackend.vo.AssociateDetailsVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class ControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Mock
	private ParticipationMetricsRepository participationMetricsRepository;
	
	@Mock
	private ParticipationMetricsCustomRepository participationMetricsCustomRepository;
	
	@Mock
	private GenericMetricOutputVo genericMetricOutputVo;
	
	@InjectMocks
	private ParticipationMetricsController participationController;
	
	
	@Before
	public void setup() throws Exception
	{
		//mockMvc = MockMvcBuilders.standaloneSetup(participationController).build();
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}
	@Test
	public void testHeadCount() throws Exception
	
	{
		//mockMvc.perform(MockMvcRequestBuilders.get("/participationMetrics/hello")).andExpect(MockMvcResultMatchers.status().isOk());
		mockMvc.perform(MockMvcRequestBuilders.get("/participationMetrics/headCount").accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.*",Matchers.notNullValue()));
	}
	
	@Test
	public void testUniqueVolunteeringDetailsByLocation() throws Exception
	
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/participationMetrics/uniqueVolunteeringDetailsByLocation/Coimbatore").accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.*",Matchers.notNullValue()));
	}
	
	@Test
	public void testUniqueVolunteeringDetailsByBU() throws Exception
	
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/participationMetrics/uniqueVolunteeringDetailsByBU/Recruitment").accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.*",Matchers.notNullValue()));
	}
	
}