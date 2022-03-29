package br.com.itau.modulochavepix;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.internal.InheritingConfiguration;
import org.modelmapper.internal.TypeResolvingList;
import org.modelmapper.spi.NameTokenizer;
import org.modelmapper.spi.ValueReader;
import org.modelmapper.spi.ValueWriter;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class ModuloChavePixApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testModelMapper() {
		ModelMapper actualModelMapperResult = (new ModuloChavePixApplication()).modelMapper();
		assertTrue(actualModelMapperResult.getTypeMaps().isEmpty());
		Configuration configuration = actualModelMapperResult.getConfiguration();
		assertEquals(11, configuration.getConverters().size());
		assertNull(configuration.getPropertyCondition());
		assertEquals(Configuration.AccessLevel.PUBLIC, configuration.getFieldAccessLevel());
		NameTokenizer expectedSourceNameTokenizer = configuration.getDestinationNameTokenizer();
		assertSame(expectedSourceNameTokenizer, configuration.getSourceNameTokenizer());
		List<ValueWriter<?>> valueWriters = configuration.getValueWriters();
		assertTrue(valueWriters instanceof TypeResolvingList);
		List<ValueReader<?>> valueReaders = configuration.getValueReaders();
		assertTrue(valueReaders instanceof TypeResolvingList);
		assertEquals(Configuration.AccessLevel.PUBLIC, configuration.getMethodAccessLevel());
		assertSame(valueReaders, ((InheritingConfiguration) configuration).valueAccessStore.getValueReaders());
		assertSame(valueWriters, ((InheritingConfiguration) configuration).valueMutateStore.getValueWriters());
	}

}
