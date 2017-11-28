# Script for scraping database.txt file and creating new file w/ ideal formating for fast object creation in Java.

import re
import os

current_directory_path = os.getcwd()
file_name = "database.txt"
my_file_path = os.path.join(current_directory_path, file_name)
print("---> The file to be read is located here: %s" % my_file_path)
my_file = open(my_file_path)
file_lines = my_file.readlines()
my_file.close()

# Get the movie YEAR from the string
get_year_regx = re.compile(r'\d\d\d\d')

# Get the movie SCORE from the string
get_score_regx = re.compile(r'\d\.\d')

# Get the movie TITLE from the string
get_title_regx = re.compile(r'\".*\"')

# Get RATING from the string
get_rating_regx = re.compile(r'(G|PG|PG-13|R|NR),')

# Get movie GENRES from string
get_genres_regx = re.compile(r'(Comedy|Classics|Family|Kids|Musical|Performing Arts|Science Fiction|Fantasy|Drama|Mystery|Suspense|Thriller|Horror|Action|Adventure|Art House|International|Romance|Animation|Special Interest|Western|Documentary)+')


# MY MAIN
# - Creating new file "javainput.txt", with required format.
# Get this format: 
# String movieTitle, String releaseYear, String movieScore, String movieRating, String movieGenre


count = 0
new_file_name = "javainput.txt"
new_file_path = os.path.join(current_directory_path, new_file_name)
print("---> The new file will be created here: %s" % new_file_path)
my_new_file = open(new_file_path, 'w')

for line in file_lines:
	try:
		count+=1
		the_string = ""
		the_string += str(get_title_regx.search(line).group())
		the_string += ", \""
		the_string += str(get_year_regx.search(line).group())
		the_string += "\", \""
		the_string += str(get_score_regx.search(line).group())
		the_string += "\", \""
		the_string += str(get_rating_regx.search(line).group().strip(","))
		
		for genre in get_genres_regx.findall(line):
			the_string += "\", \""
			the_string += genre
		
		the_string += "\"\n"

		# print("########## %s\nTitle: %s\nYear: %s\nScore: %s\nRating: %s\nGenres: %s\n\n" % (count,movie_title.group(), movie_year.group(), movie_score.group(), movie_rating.group().strip(","), movie_genres))
		# print(the_string)
		my_new_file.write(the_string)

	except:
		print(">>-----> ERROR")
		print(">>-----> Count: %s" % count)
		print(">>-----> Title: %s\n" % get_title_regx.search(line).group())
		break

# Sample Output:
# "The Wizard of Oz", "1939", "9.4", "G", "Classics", "Kids", "Family", "Musical", "Performing Arts", "Science Fiction", "Fantasy"
my_new_file.close()
print("---> %s movies were written to the file \"javainput.txt\"" % count)

