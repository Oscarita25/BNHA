package com.oscar.obsidianAPI.exceptions;

@SuppressWarnings("serial")
public class MissingImporterException extends Exception
{
	public MissingImporterException(String extension)
	{
		super("There is no importer for ths file type: ." + extension);
	}
}
