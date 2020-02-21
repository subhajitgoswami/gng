package com.assignment.resource.gng.resources.note;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.resource.gng.model.AccessTokenMapper;

@RestController
public class NoteResource {

	@PreAuthorize("hasAuthority('create_role')")
	@RequestMapping(value = "/note", method = RequestMethod.POST)
	public String createNote() {

		AccessTokenMapper accessTokenMapper = (AccessTokenMapper) ((OAuth2AuthenticationDetails) SecurityContextHolder
				.getContext().getAuthentication().getDetails()).getDecodedDetails();

		System.out.println("ID:" + accessTokenMapper.getId());
		System.out.println("Name:" + accessTokenMapper.getName());
		System.out.println("Email ID:" + accessTokenMapper.getUserName());

		return "Note has been created successfully";
	}

	@PreAuthorize("hasAuthority('edit_role')")
	@RequestMapping(value = "/note", method = RequestMethod.PUT)
	public String updateNote() {
		return "Note has been updated successfully";
	}

	@PreAuthorize("hasAuthority('delete_role')")
	@RequestMapping(value = "/note", method = RequestMethod.DELETE)
	public String deleteNote() {
		return "Note has been deleted successfully";
	}

	@PreAuthorize("hasAuthority('view_role')")
	@RequestMapping(value = "/note", method = RequestMethod.GET)
	public String viewAllNotes() {
		return "Notes ALL API response";
	}

	@PreAuthorize("hasAuthority('view_role')")
	@RequestMapping(value = "/noteById", method = RequestMethod.GET)
	public String viewNotesByID() {
		return "Notes By ID response";
	}

}
