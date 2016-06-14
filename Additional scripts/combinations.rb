#Note: delete empty arrays

#licenses
licenses = ["boost-1.txt", "W3CLic.txt", "emacsLic.txt", "kerberos.txt", "public domain", "postgresql.txt", "Cecill.txt", "CC.txt", "QPLv1.txt", "FSFUnlimited.txt", "postgresqlRef.txt", "IBMv1.txt", "MPLv1.txt", "ArtisticLicensev1.txt", "phpLic.txt", "SameAsPerl.txt", "NPLv1.txt", "zendv2.txt", "MX4J.txt", "BeerWare.txt", "Intel.txt", "X11CMU.txt", "simpleLicense1.txt", "simpleLic2.txt", "simpleLic.txt", "CPL.txt", "sunRPC.txt", "SunSimpleLic.txt", "UNKNOWN.txt", "NONE.txt", "RIGHTS.txt", "Copyright.txt", "AAL.txt", "AFL.txt", "AFL-1.1.txt", "AFL-1.2.txt", "AFL-2.0.txt", "AFL-2.1.txt", "AFL-3.0.txt", "AGPL-1.0.txt", "AGPLv3+.txt", "Apache.txt", "Apache-1.0.txt", "Apache-1.1.txt", "Apache-2.0.txt", "BSD.txt", "spdxBSD4.txt", "spdxBSD3.txt", "spdxBSD2.txt", "BSD3.txt", "BSD4.txt", "BSD2.txt", "BSD1.txt", "BSD-4-Clause-UC.txt", "BSD-Doc.txt", "BSD-style.txt", "CC.txt", "EUPL.txt", "EUPL-1.0.txt", "EUPL-1.1.txt", "GFDL-1.1.txt", "GFDL-1.2.txt", "GFDL-1.3.txt", "GPL.txt", "GPLv1.txt", "GPLv1+.txt", "GPLv2.txt", "GPLv2+.txt", "GPLv3.txt", "GPLv3+.txt", "LGPL.txt", "LesserGPL.txt", "LibraryGPL.txt", "LGPL-2.1.txt", "LGPL-2.1+.txt", "LGPL-2.1+-KDE-exception.txt", "LGPL-3.0.txt", "LGPL-3.0+.txt", "MIT.txt", "MIT-style.txt", "OSL.txt", "OSL-1.0.txt", "OSL-1.1.txt", "OSL-2.0.txt", "OSL-2.1.txt", "OSL-3.0.txt", "public_domain.txt", "DoWhatTheFuckYouWant"]
license_appearences = []
license_combination = []
out_file0 = File.new("combinations.txt", "w")
output = File.open( "combinations.txt","w" )
folder_paths = []
i = 0
j = 0
k = 0

# retrieve all child directories (repositories) paths
Dir.entries('.').select{ |e| File.directory?(e) }.each do |folderpath|
	folder_paths << folderpath
end

# initialize license_appearences

licenses.each do |element|
	license_appearences[j] = 0
	j += 1
end		

folder_paths.each do |path|	
	Dir.chdir(path) do	
		Dir.entries('.').select{ |e| File.file?(e) }.each do |filepath|	
			licenses.each do |currentLicense|		
				if filepath.include? currentLicense				
					license_combination.push(currentLicense)
				end
			end	
		end		
		output << license_combination.inspect
		output << "\n"
		license_combination.clear			
	end	
end
output.close		
	