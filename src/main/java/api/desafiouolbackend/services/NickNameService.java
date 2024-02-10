package api.desafiouolbackend.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import api.desafiouolbackend.repositorys.PlayerRepository;

@Service
public class NickNameService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	PlayerRepository playerRepository;

	public String validHeroAvengers() throws JsonMappingException, JsonProcessingException {

		String apiUrl = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";
		String response = restTemplate.getForObject(apiUrl, String.class);

		Set<String> nomesHerois = new HashSet<>();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(response);
		JsonNode vingadoresArray = rootNode.get("vingadores");
		if (vingadoresArray.isArray()) {
			for (JsonNode heroiNode : vingadoresArray) {
				String codinome = heroiNode.get("codinome").asText();

				nomesHerois.add(codinome);
			}
		}
		nomesHerois.removeAll(playerRepository.grouphero());
		List<String> list = new ArrayList<String>(nomesHerois);

		if (list.size() == 0) {
			return "";
		} else {
			System.out.println(list.get(0));
			return list.get(0);
		}

	}

	public String validHeroJustice() throws JsonMappingException, JsonProcessingException {
		String apiUrl = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";
		String response = restTemplate.getForObject(apiUrl, String.class);

		Set<String> nomesHerois = new HashSet<>();

		XmlMapper xmlMapper = new XmlMapper();
		JsonNode rootNode = xmlMapper.readTree(response);

		JsonNode codinomesArray = rootNode.get("codinomes");
		JsonNode codinomeArray = codinomesArray.get("codinome");

		if (codinomeArray.isArray()) {
			for (JsonNode heroiNode : codinomeArray) {
				String codinome = heroiNode.asText();

				nomesHerois.add(codinome);
			}
		}

		nomesHerois.removeAll(playerRepository.grouphero());
		List<String> list = new ArrayList<String>(nomesHerois);

		if (list.size() == 0) {
			return "";
		} else {
			System.out.println(list.get(0));
			return list.get(0);
		}
	}

}
