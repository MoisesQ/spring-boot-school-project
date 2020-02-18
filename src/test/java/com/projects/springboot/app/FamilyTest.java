package com.projects.springboot.app;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.springboot.app.controllers.FamilyController;
import com.projects.springboot.app.entity.Family;
import com.projects.springboot.app.entity.Parent;
import com.projects.springboot.app.service.FamilyService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(FamilyController.class)
public class FamilyTest {

	@Autowired
	private MockMvc mockTest;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	private FamilyService familyService;
	
	//Parent test
	private Parent parentTest = new Parent(3L, "F", "Nina", "Luz", "Vasquez", "Parent");
	
	//Parent test2 to update
	private Parent parentTest2 = new Parent(3L, "M", "Marcos", "Antonio", "Dominguez", "Parent");

	//Family test
	private Family familyTest = new Family(4L, parentTest, "Los Vasquez");
	
	@Test
	public void AllFamiliesIsOkTest() throws Exception {
		List<Family> families = Arrays.asList(familyTest);
		when(familyService.findAll()).thenReturn(families);
		mockTest.perform(get("/api/families/")).andExpect(status().isOk());
	}

	@Test
	public void CreateFamilyIsOkTest() throws Exception {
		Family family = familyTest;
		when(familyService.create(family)).thenReturn(family);
		mockTest.perform(post("/api/families/").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(family))).andExpect(status().isCreated());
	}

	@Test
	public void FindOneFamilyIsOkTest() throws Exception {
		mockTest.perform(get("/api/families/{id}", 4L)).andExpect(status().isOk());	
	}

	@Test
	public void UpdateFamilyIsOkTest() throws Exception {

		Family family = new Family(4L, parentTest2, "Los Dominguez");
		
		when(familyService.update(1L, family)).thenReturn(family);
		mockTest.perform(patch("/api/families/{id}", 4L).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(family))).andExpect(status().isOk());
	}

	@Test
	public void DeleteFamilyIsOkTest() throws Exception {
		mockTest.perform(delete("/api/families/{id}", 4L)).andExpect(status().isNoContent());
	}


}
