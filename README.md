# License usage analysis and license recommendation

### License usage analysis
The following code was used to investigate license usage on GitHub. The folder "Research data" contains exemplary research data. Further information can be found in the respective thesis-paper [1].

GitDownloader:
The GitDownloader is a Java program to automatically clone projects from GitHub. It is capable of creating a list of projects hosted on GitHub by utilizing the GitHub Search API. Those projects can be cloned afterwards, to enable local access on the source files of each project.

Additional scripts:
Additional ruby-scripts allow several operations on the cloned repository structure (searching for files, string-matching in files, occurrences counting).


### License recommendation
The LicenseRecommender is a proof-of-concept to recommend licenses. The Java Applet allows users to interactively check if licenses are suitable for their projects. It includes license compatibility and combinability, license features, ranking choices and additional preferences. Further information on the tool can be found in the respective thesis-paper [1].


[1] http://softlang.uni-koblenz.de/KevinSchmidtMScThesis.pdf

[2] https://github.com/schmidtkevin

