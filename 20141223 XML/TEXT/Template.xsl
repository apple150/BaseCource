<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html"/>
	<xsl:template match="/pointList">
		<table border="1">
			<xsl:apply-templates/>
		</table>
	</xsl:template>
<xsl:template match="/pointList/point">
	<tr>
		<xsl:apply-templates/>
	</tr>
</xsl:template>
<xsl:template match="/pointList/point/x">
	<td>
		<xsl:value-of select="text()"/>
		<xsl:value-of select="../@unit"/>
	</td>
</xsl:template>
<xsl:template match="/pointList/point/y">
	<td>
		<xsl:value-of select="text()"/>
		<xsl:value-of select="../@unit"/>
	</td>
</xsl:template>
</xsl:stylesheet>