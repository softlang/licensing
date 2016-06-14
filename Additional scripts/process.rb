# Note: license names can include other license names (e.g. BSD is included in BSD3 - substract!)
#paths
license_file_paths = []
folder_paths = []

#licenses (adapt to search!)
licenses = ['boost-1', 'W3CLic', 'emacsLic', 'kerberos', 'postgresql', 'Cecill', 'CC', 'QPLv1', 'FSFUnlimited', 'postgresqlRef', 'IBMv1', 'MPLv1', 'ArtisticLicensev1', 'phpLic', 'SameAsPerl', 'NPLv1', 'zendv2', 'MX4J', 'BeerWare', 'Intel', 'X11CMU', 'simpleLicense1', 'simpleLic2', 'simpleLic', 'CPL', 'sunRPC', 'SunSimpleLic', 'UNKNOWN', 'NONE', 'RIGHTS', 'Copyright', 'AAL', 'AFL', 'AFL-1.1', 'AFL-1.2', 'AFL-2.0', 'AFL-2.1', 'AFL-3.0', 'AGPL-1.0', 'AGPLv3+', 'Apache', 'Apache-1.0', 'Apache-1.1', 'Apache-2.0', 'BSD', 'spdxBSD4', 'spdxBSD3', 'spdxBSD2', 'BSD3', 'BSD4', 'BSD2', 'BSD1', 'BSD-4-Clause-UC', 'BSD-Doc', 'BSD-style', 'CC', 'EUPL', 'EUPL-1.0', 'EUPL-1.1', 'GFDL-1.1', 'GFDL-1.2', 'GFDL-1.3', 'GPL', 'GPLv1', 'GPLv1+', 'GPLv2', 'GPLv2+', 'GPLv3', 'GPLv3+', 'LGPL', 'LesserGPL', 'LibraryGPL', 'LGPL-2.1', 'LGPL-2.1+', 'LGPL-2.1+-KDE-exception', 'LGPL-3.0', 'LGPL-3.0+', 'MIT', 'MIT-style', 'OSL', 'OSL-1.0', 'OSL-1.1', 'OSL-2.0', 'OSL-2.1', 'OSL-3.0', 'public_domain', 'public domain', 'DoWhatTheFuckYouWant']
license_appearences =[]
i = 0
j = 0

# retrieve all child directories (repositories) paths
Dir.entries('.').select{ |e| File.directory?(e) }.each do |folderpath|
	folder_paths << folderpath
end

# check for all repositorie folders
folder_paths.each do |childfolder|

	Dir.chdir(childfolder) do
		puts("currrently analyzing :" + childfolder)

		# retrieve all .license-file paths and store in array
		Dir['**/*'].select{|f| File.file?(f) }.each do |filepath|
			license_file_paths << filepath if filepath =~ /.*\.license$/
		end
		
		# check for licenses in all existant paths
		license_file_paths.each do |licensefile|
			currentFile = File.foreach(licensefile)
			licenses.each do |currentLicense|				
				if currentFile.any?{ |l| l[currentLicense] }				
					license_appearences[i] = 1 
				end
				i += 1				
			end	
			i = 0
		end		
	
		# make license.txt for all found licenses
		licenses.each do	
			if license_appearences[j] == 1
				if licenses[j] != nil
					out_file0 = File.new(licenses[j] + ".txt", "w")
				end	
			end	
			j += 1
		end			
		
		# clear for next iteration
		license_file_paths.clear
		license_appearences.clear
		i = 0
		j = 0	
		
	end
end

