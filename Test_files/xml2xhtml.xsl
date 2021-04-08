<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:key name="journalsByJournalTitle" match="journal" use="journalTitle"/>
	<xsl:key name="journalsByPublisher" match="journal" use="publisher"/>
	<xsl:key name="conferencesByVenue" match="conference" use="venue"/>
	<xsl:key name="conferencesByLocation" match="conference" use="location"/>
	<xsl:key name="bookChaptersByBookTitle" match="bookChap" use="bookTitle"/>
	<xsl:key name="bookChaptersByPublisher" match="bookChap" use="publisher"/>
	<xsl:template match="/">
  		<html>
			<body style="font-family:Times New Roman;font-size:12pt;background-color:#EEEEEE">
				<h1>Bibliography summary</h1>
				<h2>Journal articles</h2>
				<p>
					Number of journal articles:
					<xsl:value-of select="count(/bibliography/journal)"/>
				</p>
				<p>
					Most frequent journal:
					<xsl:for-each select="/bibliography/journal/journalTitle">
						<xsl:sort select="count(key('journalsByJournalTitle', .))" data-type="number" order="descending"/>
						<xsl:if test="position() = 1">
							<xsl:value-of select="." />
						</xsl:if>
					</xsl:for-each>
				</p>
				<p>
					Most frequent publisher:
					<xsl:for-each select="/bibliography/journal/publisher">
						<xsl:sort select="count(key('journalsByPublisher', .))" data-type="number" order="descending"/>
						<xsl:if test="position() = 1">
							<xsl:value-of select="." />
						</xsl:if>
					</xsl:for-each>
				</p>

				<h2>Conference proceedings</h2>
				<p>
					Number of conference proceedings:
					<xsl:value-of select="count(/bibliography/conference)"/>
				</p>
				<p>
					Most frequent venue:
					<xsl:for-each select="/bibliography/conference/venue">
						<xsl:sort select="count(key('conferencesByVenue', .))" data-type="number" order="descending"/>
						<xsl:if test="position() = 1">
							<xsl:value-of select="." />
						</xsl:if>
					</xsl:for-each>
				</p>
				<p>
					Most frequent location:
					<xsl:for-each select="/bibliography/conference/location">
						<xsl:sort select="count(key('conferencesByLocation', .))" data-type="number" order="descending"/>
						<xsl:if test="position() = 1">
							<xsl:value-of select="." />
						</xsl:if>
					</xsl:for-each>
				</p>

				<h2>Book chapters</h2>
				<p>
					Number of book chapters:
					<xsl:value-of select="count(/bibliography/bookChap)"/>
				</p>
				<p>
					Most frequent book:
					<xsl:for-each select="/bibliography/bookChap/bookTitle">
						<xsl:sort select="count(key('bookChaptersByBookTitle', .))" data-type="number" order="descending"/>
						<xsl:if test="position() = 1">
							<xsl:value-of select="." />
						</xsl:if>
					</xsl:for-each>
				</p>
				<p>
					Most frequent publisher:
					<xsl:for-each select="/bibliography/bookChap/publisher">
						<xsl:sort select="count(key('bookChaptersByPublisher', .))" data-type="number" order="descending"/>
						<xsl:if test="position() = 1">
							<xsl:value-of select="." />
						</xsl:if>
					</xsl:for-each>
				</p>
			</body>
  		</html>
	</xsl:template>
</xsl:stylesheet>