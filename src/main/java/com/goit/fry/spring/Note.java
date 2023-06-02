package com.goit.fry.spring;

import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {

	@EqualsAndHashCode.Include
	private long id;
	private String title;
	private String content;
}
