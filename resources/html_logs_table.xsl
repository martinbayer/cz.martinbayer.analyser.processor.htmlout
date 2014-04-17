<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:template match="/">
		<html>

			<head>
				<title>CD Catalog</title>
				<style type="text/css">
					table
					{
					border-collapse:collapse;
					font-family: verdana;
					}
					table, td, th
					{
					border:1px solid black;
					}
				</style>
			</head>


			<body>
				<table>
					<xsl:for-each select="logrecords/logrecord">
						<tr>
							<td>Event date/time:</td>
							<td>
								<xsl:value-of select="eventDateTime" />
							</td>
						</tr>
						<tr>
							<td>File:</td>
							<td>
								<xsl:value-of select="fileName" />
							</td>
						</tr>
						<tr>
							<td>Line:</td>
							<td>
								<xsl:value-of select="line" />
							</td>
						</tr>
						<tr>
							<td>Log level:</td>
							<td>
								<xsl:value-of select="logLevel" />
							</td>
						</tr>
						<tr>
							<td>Message:</td>
							<td>
								<xsl:value-of select="message" />
							</td>
						</tr>
						<tr>
							<td>Thread name:</td>
							<td>
								<xsl:value-of select="threadName" />
							</td>
						</tr>
						<tr>
							<td>Error:</td>
							<td>
								<xsl:value-of select="errorMessage" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>