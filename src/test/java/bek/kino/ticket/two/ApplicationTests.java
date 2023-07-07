package bek.kino.ticket.two;

import bek.kino.ticket.two.BodySample.Balance;
import bek.kino.ticket.two.BodySample.ImgUpdateBody;
import bek.kino.ticket.two.BodySample.SamplePermissionId;
import bek.kino.ticket.two.api.UserController;
import bek.kino.ticket.two.dto.MainUserDTO;
import bek.kino.ticket.two.dto.PermissionDTO;
import bek.kino.ticket.two.dto.UserDTO;
import bek.kino.ticket.two.mapper.MainUserMapper;
import bek.kino.ticket.two.model.User;
import bek.kino.ticket.two.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private MainUserMapper mainUserMapper;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testMainUserDTO() {
		Long id = 1L;
		String email = "test@example.com";
		String password = "password";
		String fullName = "John Doe";
		String imgLink = "http://example.com/image.jpg";


		MainUserDTO mainUserDTO = new MainUserDTO();
		mainUserDTO.setId(id);
		mainUserDTO.setEmail(email);
		mainUserDTO.setPassword(password);
		mainUserDTO.setFullName(fullName);
		mainUserDTO.setImgLink(imgLink);


		Assertions.assertEquals(id, mainUserDTO.getId());
		Assertions.assertEquals(email, mainUserDTO.getEmail());
		Assertions.assertEquals(password, mainUserDTO.getPassword());
		Assertions.assertEquals(fullName, mainUserDTO.getFullName());
		Assertions.assertEquals(imgLink, mainUserDTO.getImgLink());
	}

	@Test
	public void testPermissionDTO() {
		Long id = 1L;
		String role = "ROLE_ADMIN";

		PermissionDTO permissionDTO = new PermissionDTO();
		permissionDTO.setId(id);
		permissionDTO.setRole(role);

		Assertions.assertEquals(id, permissionDTO.getId());
		Assertions.assertEquals(role, permissionDTO.getRole());
	}

	@Test
	public void testToDtoUser() {
		User user = new User();
		user.setId(1L);
		user.setEmail("test@example.com");
		user.setPassword("password");
		user.setFullName("John Doe");
		user.setImgLink("http://example.com/image.jpg");

		MainUserDTO userDTO = mainUserMapper.toDtoUser(user);

		Assertions.assertEquals(user.getId(), userDTO.getId());
		Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
		Assertions.assertEquals(user.getPassword(), userDTO.getPassword());
		Assertions.assertEquals(user.getFullName(), userDTO.getFullName());
		Assertions.assertEquals(user.getImgLink(), userDTO.getImgLink());
	}

	@Test
	public void testToModelUser() {
		MainUserDTO userDTO = new MainUserDTO();
		userDTO.setId(1L);
		userDTO.setEmail("test@example.com");
		userDTO.setPassword("password");
		userDTO.setFullName("John Doe");
		userDTO.setImgLink("http://example.com/image.jpg");

		User user = mainUserMapper.toModelUser(userDTO);

		Assertions.assertEquals(userDTO.getId(), user.getId());
		Assertions.assertEquals(userDTO.getEmail(), user.getEmail());
		Assertions.assertEquals(userDTO.getPassword(), user.getPassword());
		Assertions.assertEquals(userDTO.getFullName(), user.getFullName());
		Assertions.assertEquals(userDTO.getImgLink(), user.getImgLink());
	}

	@Test
	public void testToDtoListUser() {
		// Create sample User objects
		User user1 = new User();
		user1.setId(1L);
		user1.setEmail("test1@example.com");
		user1.setPassword("password1");
		user1.setFullName("John Doe");
		user1.setImgLink("http://example.com/image1.jpg");

		User user2 = new User();
		user2.setId(2L);
		user2.setEmail("test2@example.com");
		user2.setPassword("password2");
		user2.setFullName("Jane Smith");
		user2.setImgLink("http://example.com/image2.jpg");

		List<User> userList = Arrays.asList(user1, user2);

		List<MainUserDTO> userDTOList = mainUserMapper.toDtoListUser(userList);

		Assertions.assertEquals(userList.size(), userDTOList.size());

		Assertions.assertEquals(user1.getId(), userDTOList.get(0).getId());
		Assertions.assertEquals(user1.getEmail(), userDTOList.get(0).getEmail());
		Assertions.assertEquals(user1.getPassword(), userDTOList.get(0).getPassword());
		Assertions.assertEquals(user1.getFullName(), userDTOList.get(0).getFullName());
		Assertions.assertEquals(user1.getImgLink(), userDTOList.get(0).getImgLink());

		Assertions.assertEquals(user2.getId(), userDTOList.get(1).getId());
		Assertions.assertEquals(user2.getEmail(), userDTOList.get(1).getEmail());
		Assertions.assertEquals(user2.getPassword(), userDTOList.get(1).getPassword());
		Assertions.assertEquals(user2.getFullName(), userDTOList.get(1).getFullName());
		Assertions.assertEquals(user2.getImgLink(), userDTOList.get(1).getImgLink());
	}

	@Test
	public void testToUserList() {
		MainUserDTO userDTO1 = new MainUserDTO();
		userDTO1.setId(1L);
		userDTO1.setEmail("test1@example.com");
		userDTO1.setPassword("password1");
		userDTO1.setFullName("John Doe");
		userDTO1.setImgLink("http://example.com/image1.jpg");

		MainUserDTO userDTO2 = new MainUserDTO();
		userDTO2.setId(2L);
		userDTO2.setEmail("test2@example.com");
		userDTO2.setPassword("password2");
		userDTO2.setFullName("Jane Smith");
		userDTO2.setImgLink("http://example.com/image2.jpg");

		List<MainUserDTO> userDTOList = Arrays.asList(userDTO1, userDTO2);

		List<User> userList = mainUserMapper.toUserList(userDTOList);

		Assertions.assertEquals(userDTOList.size(), userList.size());

		Assertions.assertEquals(userDTO1.getId(), userList.get(0).getId());
		Assertions.assertEquals(userDTO1.getEmail(), userList.get(0).getEmail());
		Assertions.assertEquals(userDTO1.getPassword(), userList.get(0).getPassword());
		Assertions.assertEquals(userDTO1.getFullName(), userList.get(0).getFullName());
		Assertions.assertEquals(userDTO1.getImgLink(), userList.get(0).getImgLink());

		Assertions.assertEquals(userDTO2.getId(), userList.get(1).getId());
		Assertions.assertEquals(userDTO2.getEmail(), userList.get(1).getEmail());
		Assertions.assertEquals(userDTO2.getPassword(), userList.get(1).getPassword());
		Assertions.assertEquals(userDTO2.getFullName(), userList.get(1).getFullName());
		Assertions.assertEquals(userDTO2.getImgLink(), userList.get(1).getImgLink());
	}

	@Test
	@WithMockUser
	public void testUpdateProfileImg() throws Exception {
		ImgUpdateBody imgUpdateBody = new ImgUpdateBody();
		MainUserDTO mainUserDTO = new MainUserDTO();

		when(userService.updateImgInProfile(any(ImgUpdateBody.class))).thenReturn(mainUserDTO);

		mockMvc.perform(MockMvcRequestBuilders.post("/set-img")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{}"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

	@Test
	@WithMockUser
	public void testPlusBalance() throws Exception {
		Balance balance = new Balance();
		MainUserDTO mainUserDTO = new MainUserDTO();

		when(userService.topToBalance(any(Balance.class))).thenReturn(mainUserDTO);

		mockMvc.perform(MockMvcRequestBuilders.post("/plusBalance")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{}"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

	@Test
	@WithMockUser
	public void testGetCurrentSessionUser() throws Exception {
		UserDTO userDTO = new UserDTO();

		when(userService.getUserById(anyLong())).thenReturn(userDTO);

		mockMvc.perform(MockMvcRequestBuilders.get("/getCurrentUser/{id}", 1)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testGetAllUsers() throws Exception {
		List<MainUserDTO> users = new ArrayList<>();

		when(userService.getAllUsers()).thenReturn(users);

		mockMvc.perform(MockMvcRequestBuilders.get("/getAllUsers")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testAssign() throws Exception {
		SamplePermissionId samplePermissionId = new SamplePermissionId();
		MainUserDTO mainUserDTO = new MainUserDTO();

		when(userService.assign(any(SamplePermissionId.class))).thenReturn(mainUserDTO);

		mockMvc.perform(MockMvcRequestBuilders.put("/assign")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{}"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testDeletePer() throws Exception {
		SamplePermissionId samplePermissionId = new SamplePermissionId();
		MainUserDTO mainUserDTO = new MainUserDTO();

		when(userService.deletePer(any(SamplePermissionId.class))).thenReturn(mainUserDTO);

		mockMvc.perform(MockMvcRequestBuilders.delete("/deletePer")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{}"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

}
